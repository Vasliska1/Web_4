<template>

    <div class="placeBut">
        <div class="svg" style="background: #d6bfd8 ">

            <svg ref="svg" xmlns="http://www.w3.org/2000/svg"
                 @click="handClick"
                 width="500" height="500" id="graph" class="svg-graph">

                <polygon class="przamoyg" id="pr2" points="200,250 300,250 300,200, 200,200"
                         fill="red" stroke="red"></polygon>

                <polygon class="treyg" id="tr2" points="200,250 250,250 200,300"
                         fill="red" stroke="red"></polygon>

                <g transform="translate(200 250) scale(-25,25)">
                    <path d="M0 0 L 0 -2 A2 2 0 0 1  2  0 " fill="red" id="okr2" stroke="red"
                          stroke-width="0.03"></path>
                </g>

                <line class="line" x1="0" x2="400" y1="250" y2="250" stroke="black"></line>
                <line class="line" x1="200" x2="200" y1="0" y2="500" stroke="black"></line>

                <text class="text" x="250" y="240">1</text>
                <text class="text" x="300" y="240">2</text>
                <text class="text" x="350" y="240">3</text>
                <text class="text" x="390" y="240">4</text>
                <text class="text" x="-3" y="240">-4</text>
                <text class="text" x="40" y="240">-3</text>
                <text class="text" x="90" y="240">-2</text>
                <text class="text" x="140" y="240">-3</text>
                <text class="text" x="210" y="200">1</text>
                <text class="text" x="210" y="150">2</text>
                <text class="text" x="210" y="100">3</text>
                <text class="text" x="210" y="50">4</text>
                <text class="text" x="210" y="12">5</text>
                <text class="text" x="210" y="300">-1</text>
                <text class="text" x="210" y="350">-2</text>
                <text class="text" x="210" y="400">-3</text>
                <text class="text" x="210" y="450">-4</text>
                <text class="text" x="210" y="495">-5</text>
                <text class="text" x="390" y="220">X</text>
                <text class="text" x="235" y="13">Y</text>

                <g class="pointPlace">
                    <circle v-for="point in points" v-bind:key="point"
                            :cx="getX(point.x,point.r)"
                            :cy="getY(point.y,point.r)"
                            :fill="hit(point.result)"
                            r="3">
                    </circle>
                    <circle :cx="getX(x_value, r[0])" :cy="getY(y_value,r[0])" r="3"></circle>
                </g>
            </svg>


        </div>

        <div id="but">
            <button :disabled="!valid" @click=sendClick variant="success">Отправить</button>
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
            getX: function (x, r) {
                return 250 + x / r * 200;
            },
            getY: function (y, r) {
                return 250 - y / r * 200;
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
                this.x_value = (gp.x - 250) / 200 * this.r[0];
                this.y_value = (gp.y - 250) / (-200) * this.r[0];

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
                }

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