<template>
    <div id="main" class="d-flex flex-column">
        <button @click.prevent="logOut" id="out"> Выход</button>
        <Container/>
    </div>
</template>

<script>
    import Container from "./Container.vue";

    export default {
        name: "Main",
        components: {
            Container
        },
        methods: {
            logOut: function () {
                localStorage.clear();
                this.$router.push('/');

            }
        },
        mounted() {
            if (localStorage.getItem("auth") == null) {
                this.$router.push('/');
            }

        }
    }
</script>

<style scoped>

</style>