<template>
  <div class="container">
      <h1>Parents Landing Page</h1>
      <h4>Manage Kids From This Page</h4>
      <kid-account-block />
  </div>
</template>

<script>
import KidAccountBlock from '../components/KidAccountBlock.vue'

export default {
  name: 'parent-landing-page',
  components: {
    KidAccountBlock,
  }
}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

</style>