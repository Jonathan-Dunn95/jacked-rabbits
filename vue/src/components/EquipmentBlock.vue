<template>
  <div class="container">
    <div class="equipped-items-grid">
      <img v-for="item in equippedItems" 
      v-bind:key="item.itemId"
      :src="item.imgURL"
      @click="selectCategory(item.category)" />
    </div>
  </div>
</template>

<script>
import ItemStoreService from '../services/ItemStoreService'
import MascotService from '../services/MascotService'
export default {
    named: "equipment-block",
    methods: {
    },
    computed: {
      equippedItems() {
        return this.$store.state.equippedItems;
      }
    },
    created() {
      let equippedItems = [];
      MascotService.getMascotByKidId(this.$store.state.user.id).then( mascot => {
        console.log(mascot.data.background)
        ItemStoreService.getImage(mascot.data.shirt).then(response => {
          equippedItems.push(response.data)
          ItemStoreService.getImage(mascot.data.shoes).then(response => {
          equippedItems.push(response.data)
          ItemStoreService.getImage(mascot.data.hat).then(response => {
          equippedItems.push(response.data)
          ItemStoreService.getImage(mascot.data.accessory).then(response => {
          equippedItems.push(response.data)
          ItemStoreService.getImage(mascot.data.background).then(response => {
          equippedItems.push(response.data)
          this.$store.commit('SET_EQUIPED_ITEMS', equippedItems)
          })
          })
          })
          })
        })
        
        
        
        
      })
    }
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