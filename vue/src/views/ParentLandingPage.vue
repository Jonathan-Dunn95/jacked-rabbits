<template>
  <div class="container">
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
  margin-top: 1rem;
}

</style>