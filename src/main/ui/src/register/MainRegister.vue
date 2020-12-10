<template>
    <div id="main" class="d-flex flex-column">
        <Header/>
        <RegisterForm/>

    </div>
</template>

<script>
    import RegisterForm from "./Login";
    import Header from "./Header"

    export default {
        name: "Register",

        components: {
            Header,
            RegisterForm
        }
    }
</script>

<style scoped>
    #main {
        height: 100%;
    }
</style>