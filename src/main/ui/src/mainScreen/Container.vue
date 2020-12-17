<template>
    <div class="container-fluid ">
        <div class="basis row justify-content-center ">

            <Form @pointCreate="pointCreate($event)"
                  @r="setR"
            />


            <Graph :r="r"
                   :points="points"
                   @pointCreate="pointCreate($event)"/>

        </div>
        <div class="">
            <Table :points="points"/>
        </div>
    </div>
</template>

<script>
    import Form from "./Form.vue"
    import Graph from "./Graph.vue"
    import Table from "./Table.vue"

    import {getAllPoints, pointCreate} from './PointsFromServer'

    export default {
        name: "container",
        components: {
            Form,
            Graph,
            Table
        },
        data() {
            return {
                points: [],
                r: []
            }
        },
        methods: {
            getAllPoints() {
                getAllPoints().then(response => {
                    console.log(response)
                    this.points = response
                })
            },
            pointCreate(data) {
                console.log(2)
                console.log(data)
                pointCreate(data).then(response => {
                    console.log(response);
                    this.getAllPoints();
                    this.r = [];
                });


            },
            setR: function (r) {
                this.r = r;
            },
        },
        mounted() {
            this.getAllPoints();
        }

    }
</script>

<style scoped>

    .basis {
        background: #fddcff;
        color: black;
        padding-left: 20px;
        padding-right: 20px;
        padding-top: 50px;
        padding-bottom: 80px;
        width: auto;
        max-width: 1140px;
        min-width: 500px;
        height: auto;
        opacity: 0.8;
        border: 3px solid #fdb6fa;
        margin-left: auto;
        margin-right: auto;
        margin-top: 80px;


    }

</style>