<template>

    <div class="placeBut col-auto">
        <div id="infoR" v-show="!this.r.length" style="position: absolute; color: red; margin-left: 10px">
            Чтобы отправить данные с графика выберите R!!!
        </div>
        <div class="svg" style="background: rgba(178,62,166,0.56); margin-top: 30px">

            <svg ref="svg" xmlns="http://www.w3.org/2000/svg"
                 @click="handClick"
                 width="400" height="400" id="graph" class="svg-graph">

                <svg v-show="ifR3()" class="R3">

                    <polygon class="przamoyg" id="pr2" points="100,250 250,250 250,325, 100,325"
                             fill="purple" stroke="black"></polygon>

                    <polygon class="treyg" id="tr2" points="250,250 325,250 250,100"
                             fill="purple" stroke="black"></polygon>

                    <g transform="translate(250 250) scale(37.5,-37.5)">
                        <path d="M0 0 L 0 -2 A2 2 0 0 1  2  0 " fill="purple" id="okr2" stroke="black"
                              stroke-width="0.03"></path>
                    </g>

                </svg>
                <svg v-show="ifR2()" class="R3">
                    <polygon class="przamoyg" id="pr2" points="150,250 250,250 250,300, 150,300"
                             fill="#ff66d9" stroke="black"></polygon>

                    <polygon class="treyg" id="tr2" points="250,250 300,250 250,150"
                             fill="#ff66d9" stroke="black"></polygon>

                    <g transform="translate(250 250) scale(25,-25)">
                        <path d="M0 0 L 0 -2 A2 2 0 0 1  2  0 " fill="#ff66d9" id="okr2" stroke="black"
                              stroke-width="0.05"></path>
                    </g>


                </svg>

                <svg v-show="ifR1()" class="R3">
                    <polygon class="przamoyg" id="pr1" points="200,250 250,250 250,275, 200,275"
                             fill="pink" stroke="black"></polygon>

                    <polygon class="treyg" id="tr1" points="250,250 275,250 250,200"
                             fill="pink" stroke="black"></polygon>

                    <g transform="translate(250 250) scale(12.5,-12.5)">
                        <path d="M0 0 L 0 -2 A2 2 0 0 1  2  0 " fill="pink" id="okr1" stroke="black"
                              stroke-width="0.05"></path>
                    </g>
                </svg>

                <line class="line" x1="0" x2="400" y1="250" y2="250" stroke="black"></line>
                <line class="line" x1="250" x2="250" y1="0" y2="400" stroke="black"></line>

                <text class="text" x="200" y="240">-1</text>
                <text class="text" x="300" y="240">1</text>
                <text class="text" x="350" y="240">2</text>
                <text class="text" x="390" y="240">3</text>
                <text class="text" x="-3" y="240">-5</text>
                <text class="text" x="40" y="240">-4</text>
                <text class="text" x="90" y="240">-3</text>
                <text class="text" x="140" y="240">-2</text>

                <text class="text" x="390" y="220">X</text>
                <text class="text" x="255" y="13">Y</text>

                <text class="text" x="220" y="200">1</text>
                <text class="text" x="220" y="150">2</text>
                <text class="text" x="220" y="100">3</text>
                <text class="text" x="220" y="50">4</text>
                <text class="text" x="220" y="12">5</text>
                <text class="text" x="220" y="300">-1</text>
                <text class="text" x="220" y="350">-2</text>
                <text class="text" x="220" y="400">-3</text>
                <text class="text" x="220" y="450">-4</text>
                <text class="text" x="220" y="495">-5</text>
                <g class="pointPlace">
                    <circle v-for="point in points" v-bind:key="point"
                            :cx="getX(point.x)"
                            :cy="getY(point.y)"
                            :fill="hit(point.result)"
                            r="3">
                    </circle>
                    <circle :cx="getX(x_value)" :cy="getY(y_value)" r="3"></circle>
                </g>

            </svg>


        </div>

        <div class="butt">
            <button class="glow-on-hover" :disabled="!valid" @click=sendClick variant="success">Отправить</button>
        </div>

    </div>
</template>

<script>
    export default {

        name: "Graph",
        props: ['r', 'points'],
        data() {
            return {
                x_value: '',
                y_value: '',

            }
        },

        methods: {
            ifR3: function () {
                return this.r.includes("3");
            },
            ifR2: function () {
                return this.r.includes("2");
            },
            ifR1: function () {
                return this.r.includes("1");
            },
            getX: function (x) {
                return 250 + x * 100 / 2;
            },
            getY: function (y) {
                return 250 - y * 100 / 2;
            },
            hit: function (hit) {
                return hit ? "green" : "red";
            },
            handClick: function (event) {

                let svg = this.$refs.svg
                console.log(this.r[1] + "hello")

                let pt = svg.createSVGPoint();
                pt.x = event.clientX;
                pt.y = event.clientY;
                let gp = pt.matrixTransform(svg.getScreenCTM().inverse())
                this.x_value = (gp.x - 250) * 2 / 100;
                this.y_value = -(gp.y - 250) * 2 / 100;

            },

            sendClick: function () {
                for (let j = 0; j < this.r.length; j++) {
                    console.log(this.r.length)
                    let payload = {
                        x: this.x_value,
                        y: this.y_value,
                        r: this.r[j]
                    };
                    this.$emit('pointCreate', payload)

                    this.$root.$refs.compname_component.clearForm();
                }
                this.x_value = -10;
                this.y_value = -10;

            },
            validR: function () {
                let count = 0;
                this.r.forEach((element) => {
                    if (element < 0)
                        count++
                })
                console.log(count + "count")
                return count <= 0;
            }
        },
        computed: {
            valid: function () {
                return this.y_value &&
                    this.x_value &&
                    this.r.length && this.validR()

            }
        }
    }

</script>

<style>

    .butt{
        margin-left: 100px;
        margin-top: 20px;
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