<template>
    <div class="logoHeader">
        <router-link v-bind:to="{ name: 'home' }">
        <img class="logo" src="../../img/Logo.jpeg" alt="logo">
        </router-link>
        <div class="spacer">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
        &nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''">Login</router-link>
        </div>
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
    border-bottom: var(--primary400) 0.5rem solid;
    padding-bottom: 0.25rem;
}
.logo {
  margin-left: 1rem;
  margin-top: 0.5rem;
  height: 100px;
}
.spacer {
  display: flex;
  align-items: center;
  align-self: flex-end;
  color: var(--primary600);
  margin: 0.5rem;
  margin-right: 3.5rem;
  font-size: 1rem;
}
</style>