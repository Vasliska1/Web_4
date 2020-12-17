<template>
    <div id="main" class="d-flex flex-column justify-content: center">

        <Header/>
        <RegisterForm/>


            <svg>
                <symbol id="s-text">
                    <text text-anchor="middle" x="50%" y="50%"> Дизайн</text>
                </symbol>

                <g class="g-ants">
                    <use xlink:href="#s-text" class="text-copy"></use>
                    <use xlink:href="#s-text" class="text-copy"></use>
                    <use xlink:href="#s-text" class="text-copy"></use>
                    <use xlink:href="#s-text" class="text-copy"></use>
                    <use xlink:href="#s-text" class="text-copy"></use>
                </g>
            </svg>

        <div style="margin: auto">
            <h1><span>B</span><span>Y</span></h1>
        </div>


        <div id="container" style="margin: auto ;  ">

            <div id=flip>
                <div><div>Бирих</div></div>
                <div><div>Лисицина</div></div>
                <div><div>Лебедев</div></div>
            </div>

        </div>



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

    @import url('https://fonts.googleapis.com/css?family=Roboto:700');



    #container {
        color: #999;
        text-transform: uppercase;
        font-size: 36px;
        font-weight: bold;

    }

    #flip {
        height:50px;
        overflow:hidden;
    }

    #flip > div > div {
        color: #fff8f6;
        padding:4px 12px;
        height:45px;
        margin-bottom:45px;
        display:inline-block;
    }

    #flip div:first-child {
        animation: show 5s linear infinite;
        width: 240px;

    }

    #flip div div {
        background: #f100f3;

    }
    #flip div:first-child div {
        background: #9b00f3;
    }
    #flip div:last-child div {
        background: #dc295a;

    }

    @keyframes show {
        0% {margin-top:-270px;}
        5% {margin-top:-180px;}
        33% {margin-top:-180px;}
        38% {margin-top:-90px;}
        66% {margin-top:-90px;}
        71% {margin-top:0px;}
        99.99% {margin-top:0px;}
        100% {margin-top:-270px;}
    }




    @import url(https://fonts.googleapis.com/css?family=Signika:700,300,600);


    h1 {
        font-size:2em;
        font:bold 5.5vw/1.6 'Signika', sans-serif;
        user-select:none;
    }

    h1 span { display:inline-block; animation:float .2s ease-in-out infinite; }
    @keyframes float {
        0%,100%{ transform:none; }
        33%{ transform:translateY(-1px) rotate(-2deg); }
        66%{ transform:translateY(1px) rotate(2deg); }
    }
    body:hover span { animation:bounce .6s; }
    @keyframes bounce {
        0%,100%{ transform:translate(0); }
        25%{ transform:rotateX(20deg) translateY(2px) rotate(-3deg); }
        50%{ transform:translateY(-20px) rotate(3deg) scale(1.1);  }
    }

    span:nth-child(4n) { color: hsl(331, 79%, 49%); text-shadow:1px 1px hsl(359, 35%, 68%), 2px 2px hsl(313, 17%, 58%), 3px 3px hsl(312, 18%, 57%), 4px 4px hsl(50, 75%, 45%); }
    span:nth-child(4n-1) { color: hsl(267, 40%, 51%); text-shadow:1px 1px hsl(135, 35%, 45%), 2px 2px hsl(135, 35%, 45%), 3px 3px hsl(337, 54%, 39%), 4px 4px hsl(135, 35%, 45%); }
    span:nth-child(4n-2) { color: hsl(260, 36%, 59%); text-shadow:1px 1px hsl(155, 25%, 50%), 2px 2px hsl(308, 60%, 39%), 3px 3px hsl(155, 25%, 50%), 4px 4px hsl(140, 25%, 50%); }
    span:nth-child(4n-3) { color: hsl(324, 65%, 59%); text-shadow:1px 1px hsl(30, 45%, 50%), 2px 2px hsl(30, 45%, 50%), 3px 3px hsl(30, 45%, 50%), 4px 4px hsl(30, 45%, 50%); }

    h1 span:nth-child(2){ animation-delay:.05s; }
    h1 span:nth-child(3){ animation-delay:.1s; }
    h1 span:nth-child(4){ animation-delay:.15s; }
    h1 span:nth-child(5){ animation-delay:.2s; }
    h1 span:nth-child(6){ animation-delay:.25s; }
    h1 span:nth-child(7){ animation-delay:.3s; }
    h1 span:nth-child(8){ animation-delay:.35s; }
    h1 span:nth-child(9){ animation-delay:.4s; }
    h1 span:nth-child(10){ animation-delay:.45s; }
    h1 span:nth-child(11){ animation-delay:.5s; }
    h1 span:nth-child(12){ animation-delay:.55s; }
    h1 span:nth-child(13){ animation-delay:.6s; }
    h1 span:nth-child(14){ animation-delay:.65s; }

    @import url(https://fonts.googleapis.com/css?family=Montserrat);

    svg {
        display: block;
        font: 5.5em 'Montserrat';
        width: 350px;
        height: 120px;
        margin: 0 auto;
        margin-top: 100px;
    }

    .text-copy {
        fill: none;
        stroke: white;
        stroke-dasharray: 6% 29%;
        stroke-width: 5px;
        stroke-dashoffset: 0%;
        animation: stroke-offset 5.5s infinite linear;
    }

    .text-copy:nth-child(1) {
        stroke: #4D163D;
        animation-delay: -1s;
    }

    .text-copy:nth-child(2) {
        stroke: #844569;
        animation-delay: -2s;
    }

    .text-copy:nth-child(3) {
        stroke: #966abd;
        animation-delay: -3s;
    }

    .text-copy:nth-child(4) {
        stroke: #fcc8e8;
        animation-delay: -4s;
    }

    .text-copy:nth-child(5) {
        stroke: #fd3cc6;
        animation-delay: -5s;
    }

    @keyframes stroke-offset {
        100% {
            stroke-dashoffset: -35%;
        }
    }

    #main {
        height: 100%;
    }
</style>