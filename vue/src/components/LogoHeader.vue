<template>
    <div class="logoHeader">
        <img class="logo" src="https://mykidswellnessapp-media.s3.amazonaws.com/logos/logoIdea2.jpg" alt="logo">
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
  height: 10rem;
}
</style>