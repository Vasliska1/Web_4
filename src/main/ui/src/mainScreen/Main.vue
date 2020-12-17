<template>
    <div id="main" class="d-flex flex-column">
        <div class="row justify-content-between">
            <div>
                <button class="btn" @click.prevent="logOut" id="out"> Выход</button>
            </div>


            <Container/>

        </div>
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

            },
            getName() {
                localStorage.getItem("auth")
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

    @import url('https://fonts.googleapis.com/css?family=Lato:100&display=swap');


    .btn {
        margin-left: 20px;
        margin-top: 20px;
        width: 180px;
        height: 60px;
        cursor: pointer;
        background: transparent;
        border: 1px solid #febeff;
        outline: none;
        transition: 1s ease-in-out;
    }


    .btn:hover {
        transition: 1s ease-in-out;
        background: #B23EA6;
    }

    .btn:hover svg {
        stroke-dashoffset: -480;
    }

    .btn span {
        color: white;
        font-size: 18px;
        font-weight: 100;
    }

</style>