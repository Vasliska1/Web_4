<template>
    <div class="row justify-content-center flex-grow-1 ">
        <div class="text-center p-5 col-8 col-lg-4">

            <input type="text"
                   v-model="login"
                   class="form-control mb-4"
                   placeholder="Логин">
            <input type="password"
                   v-model="password"
                   class="form-control mb-4"
                   placeholder="Пароль">

            <div v-if="errors.length">
                <li v-for="item in errors" :key="item">
                    {{ item }}
                </li>
            </div>
            <div v-if="info">
                <strong>{{ info }}</strong>
            </div>
            <button @click.prevent="authorize" class="btn btn-info btn-block my-4" id="log-in">Вход</button>
            <button @click.prevent="register" class="btn btn-info btn-block my-4" id="register">Регистрация</button>
            <div v-if="impInfo">
                <strong>{{ impInfo }}</strong>
            </div>

        </div>
    </div>
</template>

<script>

    import {registration, login} from './ConnectServer'


    export default {
        name: "RegisterForm",

        computed: {
            request: function () {
                return {username: this.login, password: this.password}
            },
        },
        data() {
            return {
                login: null,
                password: null,
                errors: [],
                info: '',
                authorized: true,
                impInfo: ''
            }
        },
        methods: {
            register: function () {
                this.checkForm();

                if (this.login && this.password) {
                    registration(this.request).then(response => {

                        if (response.ok) {
                            response.text().then(text => {
                                this.impInfo = text;
                            });
                        } else {
                            console.log("bad");
                            response.text().then(text => this.info = text)
                        }
                    })
                }
            },
            authorize: function () {
                this.checkForm();
                console.log(this.request.username);
                if (this.login && this.password) {
                    login(this.request).then((response) => {
                        if (response.ok) {
                            response.text().then(text => {
                                localStorage.setItem("auth", text);
                                this.$router.push('main')
                            });
                        } else
                            response.text().then(text => this.info = text);
                    })

                }
            },


            checkForm: function () {
                this.errors = [];
                this.info = '';
                if (!this.login) {
                    this.errors.push('Введите логин')
                }
                if (!this.password) {
                    this.errors.push('Введите пароль')
                }
            }
        }
    }
</script>

<style scoped>
    button {
        background: #cc93dc;
    }

    li {
        list-style-type: none;
    }
</style>