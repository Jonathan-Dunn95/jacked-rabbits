<template>
    <div class="logoHeader">
        <router-link class="logoGroup" v-bind:to="{ name: 'home' }">
            <img class="logo" src="https://mykidswellnessapp-media.s3.amazonaws.com/logos/newLogo2.jpg" alt="logo">
        </router-link>
    </div>
</template>

<script>
export default {
    name: "logo-header"
}
</script>

<style>
.logoHeader{
    display: flex;
    align-items: center;
    justify-content: space-between;
}
.logo {
  margin-left: 1rem;
  margin-top: 0.5rem;
  height: 15rem;
}
</style>