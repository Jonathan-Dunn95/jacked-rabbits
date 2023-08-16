<template>
  <div id="app" v-bind:class="currentTheme">
    <div class="theme-options">
      <div
        id="theme-white"
        v-bind:class="{'active':currentTheme === 'theme-white'}"
        v-on:click="switchTheme('theme-white')"
      ></div>
      <div
        id="theme-blue"
        v-bind:class="{'active':currentTheme === 'theme-blue'}"
        v-on:click="switchTheme('theme-blue')"
      ></div>
      <div
        id="theme-orange"
        v-bind:class="{'active':currentTheme === 'theme-yellow'}"
        v-on:click="switchTheme('theme-yellow')"
      ></div>
      <div
        id="theme-purple"
        v-bind:class="{'active':currentTheme === 'theme-purple'}"
        v-on:click="switchTheme('theme-purple')"
      ></div>
      <div
        id="theme-green"
        v-bind:class="{'active':currentTheme === 'theme-green'}"
        v-on:click="switchTheme('theme-green')"
      ></div>
      <div
        id="theme-pink"
        v-bind:class="{'active':currentTheme === 'theme-pink'}"
        v-on:click="switchTheme('theme-pink')"
      ></div> 
      </div>
    <div class="loading" v-if="isLoading">
      <img src="@/assets/bunny_loading.gif" />
    </div>
    <div class="contentLayout" v-else>
      <logo-header />
      <div class="navbar-wrapper">
        <nav-bar />
      </div>
      <router-view />
    </div>
  </div>
</template>

<script>
import LogoHeader from './components/LogoHeader.vue'
import NavBar from './components/NavBar.vue';

export default {
  components: { 
    LogoHeader,
    NavBar 
    },

    data() {
      return {
        isLoading: false,
        currentTheme: localStorage.getItem('theme-color')
      };
      },
      methods: {
        switchTheme(theme) {
          localStorage.setItem('theme-color', theme);
          this.currentTheme = localStorage.getItem('theme-color')
        }
    },
    created() {
      this.$router.beforeEach((to, from, next) => {
      this.isLoading = true;
        next();
      });
      this.$router.afterEach(() => {
        setTimeout(() => {
          this.isLoading = false;
        }, 600); // You can adjust the delay as needed
      });
  },
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500&display=swap');

body {
  margin: 0;
}
.loading {
  display: flex;
  align-items: center;
  justify-content: center;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(255, 255, 255, 0.8);
  z-index: 9999;
}
.contentLayout {
  padding: 1rem;    
  opacity: 1;
  transition: opacity 0.3s ease-in-out;
}
.contentLayout.loading {
  opacity: 0;
}

#app {
  /* width: 100vw; */
 min-height: 100vh;
  --primary200: #daffe9;
  --primary400: #47d7ac;
  --primary500: #1dc5ba;
  --primary600: #148da5;
  --primary800: #053484;

  --neutral100: hsl(183, 62%, 80%);
  --neutral200: hsl(144, 25%, 93%);
  --neutral400: hsl(162, 15%, 56%);
  --neutral500: hsl(176, 16%, 44%);
  --neutral600: hsl(190, 19%, 36%);
  --neutral800: hsl(218, 23%, 27%);
  font-family: 'Montserrat', sans-serif;
}
@import "main.css";
</style>
