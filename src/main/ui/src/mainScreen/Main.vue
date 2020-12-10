<template>
    <div id="main" class="d-flex flex-column">

        <Container/>
        <router-link to="/">start</router-link>

    </div>
</template>

<script>
    import Container from "./Container.vue";

    export default {
        name: "Main",
        components: {
            Container
        }
    }
</script>

<style scoped>

</style>