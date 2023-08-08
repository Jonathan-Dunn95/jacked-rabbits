<template>
    <div id="app">
      <logo-header />
    <div class="contentLayout">
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
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500&display=swap');

body {
  margin: 0;
}
.contentLayout {
  padding: 2rem;
}
#app {
  width: 100vw;
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
