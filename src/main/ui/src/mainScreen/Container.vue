<template>
    <div class="container-fluid ">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <Form @pointCreate="pointCreate($event)"
                      @r="setR"

                />
            </div>
            <Graph :r="r"
                   :points="points"
                    @pointCreate="pointCreate($event)"/>
        </div>
        <Table :points="points"/>
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
                });
                this.getAllPoints();
            },
            setR: function (r) {
                this.r = r;
            },
        },
        mounted() {
            console.log(11)
            this.getAllPoints();
        }

    }
</script>

<style scoped>
    div {

    }
</style>