<template>
  <div id="app">
    <div class="loading" v-if="isLoading">
      <img src="@/assets/game_loading.gif" />
    </div>
    <div class="contentLayout" v-else>
      <logo-header />
      <router-view />
    </div>
  </div>
</template>

<script>
import LogoHeader from './components/LogoHeader.vue'

export default {
  components: { 
    LogoHeader 
    },

    data() {
      return {
        isLoading: false,
      }
    },
    created() {
      this.$router.beforeEach((to, from, next) => {
      this.isLoading = true; // Show the loading GIF
        next();
      });
      this.$router.afterEach(() => {
        // Show the loading GIF for a short moment before hiding it
        setTimeout(() => {
          this.isLoading = false;
        }, 300); // You can adjust the delay as needed
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
  height: 100vh;
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
</style>
