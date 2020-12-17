<template>
    <div id="header" class="container-fluid">
        <div class="row justify-content-between">
            <div >
                Лисицина ВасилисОчка
                <br>
                Бирих ВладиславОчка
                <br>
                Вариант 28231
            </div>
            <div class="text-right">

                <div v-if="userName">
                    <img src="../assets/images/DjUCWnBKa2g.jpg" width="69" height="69" style="border-radius: 100px; ">
                    Имя пользователя:
                    <strong style="margin-right: 10px">{{ userName }}</strong>


                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Header",
        data() {
            return {
                userName: null,
            }
        },
        methods: {
            setUserName(name) {
                console.log(999)
                this.userName = name;
            }
        }, created() {
            // set componenent name
            this.$root.$refs.com = this;
        }
    }
</script>

<style scoped>
    #header {
        background-color: #d7a7d8;
    }
</style>