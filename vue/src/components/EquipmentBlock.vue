<template>
  <div id="equipment-container">
      <img class="equippedItems" 
      v-for="item in $store.state.equippedItems" 
      v-bind:key="item.id"
      :src="item.url"
      @click="selectCategory(item.category)" />
  </div>
</template>

<script>
export default {
    named: "equipment-block",
    methods: {
        equipItem(item) {
        this.$store.commit("EQUIP_ITEM", item);
        },
        selectCategory(category) { 
            this.$store.commit("SET_SELECTED_CATEGORY", category);
        },
    }
}
</script>

<style scoped>
#equipment-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    border: 10px solid var(--primary800);
    background-color: var(--primary400);
    border-radius: 0.5rem;
}
#equipment-container > img {
    height: 8rem;
    width: 8rem;
    border: 10px ridge yellow;
    border-radius: 0.5rem;
    cursor: pointer;
}
</style>