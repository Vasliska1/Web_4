<template>
    <div class="col-5">
        <form class="h-100  d-flex  justify-content-center flex-column">
            <div id="X" class="form-check form-check-inline">
                <div v-for="num in values" v-bind:key="num">
                    <input class="form-check-input" type="checkbox" v-bind:value="num" v-model="form.x_value">
                    <label class="form-check-label">{{num}}</label><br>
                </div>
            </div>
            <div>R={{ form.x_value }}</div>
            <div id="yBlock">
                <input
                        type="text"
                        id="y-value"
                        v-model="form.y_value"
                        v-on:change="validate_Y"
                        placeholder="У в интервале (-3...5)">
            </div>

            <div id="R" class="form-check form-check-inline">
                <div v-for="num in values" v-bind:key="num">
                    <input class="form-check-input" type="checkbox" v-bind:value="num" v-model="form.r_value"
                           v-on:change="setR">
                    <label class="form-check-label">{{num}}</label><br>
                </div>
            </div>
            <div>R={{ form.r_value }}</div>
            <div class="errorY"><strong v-if="errors.y">({{ errors.y }})</strong></div>
            <div class="errorR"><strong v-if="errors.r">({{ errors.r }})</strong></div>
            <div id="butMain">
                <button :disabled="!valid" @click=pointCreate variant="success">Отправить</button>
            </div>

        </form>
    </div>
</template>

<script>


    export default {
        name: "myForm",
        data() {
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
 

            setR: function () {
                this.$emit('r', this.form.r_value);
                this.validate_R();
            },
            validate_R: function () {
                let count = 0
                this.form.r_value.forEach((element) => {
                    if (element < 0)
                        count++
                })
                if (count > 0) {
                    this.errors.r = "Значение R должно быть >0"
                } else {
                    this.errors.r = ''
                }
            },
            validate_Y: function () {
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
                //this.clearForm();

            },
            clearForm() {
                this.form.x_value = [];
                this.form.y_value = "";
                this.form.r_value = [];
            }
        },
    }
</script>

<style scoped>

</style>