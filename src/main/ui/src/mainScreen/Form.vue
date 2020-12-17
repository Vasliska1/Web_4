<template>
    <div class="col-5">
        <div class="h d-flex text-center justify-content-center flex-column">
            Х:
            <div  class="form-check form-check-inline justify-content-center ">
                <div id="X" v-for="num in values" v-bind:key="num">

                    <input class="form-check-input" type="checkbox" v-bind:value="num" v-model="form.x_value">
                    <label class="form-check-label " >{{num}}</label><br>
                </div>
            </div>
            <br>


            <div id="yBlock " class="container-fluid">
                <input
                        type="text"
                        id="y-value"
                        class="container-fluid"
                        v-model="form.y_value"
                        v-on:change="validate_Y"
                        placeholder="У в интервале [-3...5]">
            </div>
            <br>
            R:
            <div  class="form-check form-check-inline justify-content-center">
                <div id="R" v-for="num in values" v-bind:key="num">
                    <input class="form-check-input" type="checkbox" v-bind:value="num" v-model="form.r_value"
                           v-on:change="setR">
                    <label class="form-check-label">{{num}}</label><br>
                </div>
            </div>
            <br>

            <div class="errorY"><strong v-if="errors.y">({{ errors.y }})</strong></div>
            <div class="errorR"><strong v-if="errors.r">({{ errors.r }})</strong></div>
            <div id="butMain">
                <button class="glow-on-hover" :disabled="!valid" @click=pointCreate variant="success">Отправить</button>
            </div>

        </div>
    </div>
</template>

<script>


    export default {
        name: "myForm",
        data() {
            return this.initialState();
        },
        computed: {
            valid: function () {
                return this.form.y_value &&
                    this.form.x_value.length &&
                    this.form.r_value.length &&
                    !this.errors.y &&
                    !this.errors.x &&
                    !this.errors.r

            }
        },
        methods: {

            initialState: function () {

                return {

                    values: ['-5', '-4', '-3', '-2', '-1', '0', '1', '2', '3'],
                    errors: {
                        x: '',
                        y: '',
                        r: ''
                    },
                    form: {
                        x_value: [],
                        y_value: '',
                        r_value: [],
                    },

                }


            },


            setR: function () {
                this.$emit('r', this.form.r_value);
                this.validate_R();
            },
            validate_R: function () {
                let count = 0
                this.form.r_value.forEach((element) => {
                    if (element <= 0)
                        count++
                })
                if (count > 0) {
                    this.errors.r = "Значение R должно быть >0"
                } else {
                    this.errors.r = ''
                }
            },
            validate_Y: function () {
                console.log(this.initialState().form.x_value + "12122121")
                let y_val = +this.form.y_value.substr(0, 14);
                if (isNaN(y_val) || y_val > 5 || y_val < -3) {
                    this.errors.y = "Значение У должно быть от -3 до 5"
                } else {
                    this.errors.y = ''
                }
            },
            pointCreate() {

                for (let i = 0; i < this.form.x_value.length; i++) {
                    for (let j = 0; j < this.form.r_value.length; j++) {
                        let payload = {
                            x: this.form.x_value[i],
                            y: this.form.y_value,
                            r: this.form.r_value[j]
                        };
                        this.$emit('pointCreate', payload)

                    }
                }
                this.clearForm();

            },
            clearForm() {

                Object.assign(this.$data, this.initialState())
            }
        },
        created() {
            this.$root.$refs.compname_component = this;
        }
    }
</script>

<style scoped>


    #X, #R label {
        padding-right: 0.4em;

    }
    #butMain {
        margin-top: 7px;
    }

    .glow-on-hover {
        width: 220px;
        height: 50px;
        border: none;
        outline: none;
        color: #fff;
        background: #ae75d8;
        cursor: pointer;
        position: relative;
        z-index: 0;
        border-radius: 10px;

    }

    .glow-on-hover:disabled {
        cursor: not-allowed;
        background-color: #f2f2f2 !important;
        color: rgba(225, 211, 204, 0.5) !important;
        border: solid 2px transparent !important;
        box-shadow: none !important;
    }

    .glow-on-hover:before {
        content: '';
        background: linear-gradient(45deg, #ff0000, #ff7300, #fffb00, #48ff00, #00ffd5, #002bff, #7a00ff, #ff00c8, #ff0000);
        position: absolute;
        top: -2px;
        left: -2px;
        background-size: 400%;
        z-index: -1;
        filter: blur(5px);
        width: calc(100% + 4px);
        height: calc(100% + 4px);
        animation: glowing 20s linear infinite;
        opacity: 0;
        transition: opacity .3s ease-in-out;
        border-radius: 10px;
    }


    .glow-on-hover:active:after {
        background: transparent;
    }

    .glow-on-hover:hover:before {
        opacity: 1;
    }

    .glow-on-hover:after {
        z-index: -1;
        content: '';
        position: absolute;
        width: 100%;
        height: 100%;
        background: #ae75d8;
        left: 0;
        top: 0;
        border-radius: 10px;
    }

    @keyframes glowing {
        0% {
            background-position: 0 0;
        }
        50% {
            background-position: 400% 0;
        }
        100% {
            background-position: 0 0;
        }
    }
</style>