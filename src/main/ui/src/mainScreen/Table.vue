<template>
    <div class="container ">
        <table class="table w-120">
            <thead>
            <tr>
                <th>X</th>
                <th>Y</th>
                <th>R</th>
                <th>Result</th>

            </tr>
            </thead>
            <tbody>
            <tr v-for="item in points" :key="item">
                <td>{{ item.x }}</td>
                <td>{{ item.y }}</td>
                <td>{{ item.r }}</td>
                <td>{{ item.result }}</td>
               </tr>
            </tbody>
        </table>
    </div>
</template>

<script>

    export default {
        name: 'Table',
        props: ['points']
    }
</script>


<style scoped>
    .container {
        opacity: 0.8;
        overflow: scroll;
        height: 500px;
        border: 3px solid #ccccfd;
        background: #fddcff;;
        min-width: 500px;
    }

    table {
        color: black;
        border-spacing: 1px;
        text-align: center;
        overflow: scroll;
    }
    td, th, tr {
        width: 20%;
        text-align: center;
    }


</style>
