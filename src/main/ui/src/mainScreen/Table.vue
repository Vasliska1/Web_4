<template>
    <div class="container">
        <table class="table table-bordered">
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
