<template>
  <div class="container">
    <div class="equipped-items-grid">
      <img v-for="item in $store.state.equippedItems" 
      v-bind:key="item.id"
      :src="item.url"
      @click="selectCategory(item.category)" />
    </div>
  </div>
</template>

<script>
export default {
    named: "equipment-block",
    methods: {
    },
}
</script>

<style scoped>
.container {
    display: flex;
    border: 10px solid var(--primary800);
    background-color: var(--primary400);
    border-radius: 0.5rem;
    padding: 1rem;
}
.equipped-items-grid {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    background-color: var(--primary400);
}
.equipped-items-grid img {
    flex: 0 1 calc(25% - 1rem);
    max-width: calc(80% - 1rem);
    border: 10px ridge yellow;
    cursor: pointer;
    margin-bottom: 2rem;
    border-radius: 0.5rem;
}
</style>