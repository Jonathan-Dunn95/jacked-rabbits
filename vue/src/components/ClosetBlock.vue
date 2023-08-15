<template>
  <div class="container">
    <div class="nav-tabs">
      <button @click="selectCategory('Shirts')" :class="{ active: selectedCategory === 'Shirts' }">Shirts</button>
      <button @click="selectCategory('Shoes')" :class="{ active: selectedCategory === 'Shoes' }">Shoes</button>
      <button @click="selectCategory('Hats')" :class="{ active: selectedCategory === 'Hats' }">Hats</button>
      <button @click="selectCategory('Accessories')" :class="{ active: selectedCategory === 'Accessories' }">Accessories</button>
      <button @click="selectCategory('Backgrounds')" :class="{ active: selectedCategory === 'Backgrounds' }">Backgrounds</button>
    </div>
    <div class="item-grid">
      <img v-for="item in displayedItems" 
      :key="item.id"
      :src="item.url"
      :class="{ selected: item === selectedItem }"
      @click="selectItem(item)"
      />
    </div>
    <button id="equip-item-btn" @click="equipItem(selectedItem)">Equip Selected Item</button>
  </div>
</template>

<script>
import MascotService from '../services/MascotService';
export default {
  name: "closet-block",
  data() {
    return {
      selectedCategory: 'Shirts',
      selectedItem: null,
    };
  },
  computed: {
    allClosetItems() {
      return this.$store.state.closetItems;
    },
    displayedItems() {
      return this.filterOutEquippedItems();
    },
  },
  methods: {
    selectCategory(category) {
      this.selectedCategory = category;
    },
    selectItem(item) {
      console.log("Selected item:", item);
      this.selectedItem = item;
    },
    equipItem(item) {
      MascotService.getMascotByKidId(this.$store.state.user.id).then( response => {
        let updatedMascot = response.data
        if(item.id<13) {
          updatedMascot.shirt = item.id
        } else if(item.id<25) {
          updatedMascot.shoes = item.id
        } else if(item.id<37) {
          updatedMascot.hat = item.id
        } else if(item.id<51) {
          updatedMascot.accessory = item.id
        } else {
          updatedMascot.background = item.id
        }
        MascotService.updateMascotById(updatedMascot).then( () => {
          this.$store.commit("EQUIP_ITEM", item);
          this.$router.go() // remove this once closet items pull from DB
        })
        
      })
      
    },
    filterOutEquippedItems() {
      return this.allClosetItems.filter(item => {
        const isEquipped = this.$store.state.equippedItems.some(equippedItem => {
          return equippedItem.category === this.selectedCategory && equippedItem.id === item.id;
        });
        return !isEquipped && item.category === this.selectedCategory;
      });
    },
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
.nav-tabs {
  display: flex;
  margin-bottom: 2rem;
}
.nav-tabs button {
  flex: 1;
  border-radius: 0.5rem;
  height: 5.5rem;
  cursor: pointer;
}
.item-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  margin-bottom: 1rem;
  background-color: var(--primary400);
}
.item-grid img {
  flex: 0 1 calc(25% - 1rem);
  max-width: calc(25% - 1rem);
  width: 100%;
  border: 5px solid var(--primary800);
  margin-bottom: 1rem;
  border-radius: 0.5rem;
  cursor: pointer;
}
.nav-tabs button.active {
  background-color: var(--primary800);
  border: 3px solid var(--primary400);
  color: white;
}
.item-grid img.selected {
  border: 5px inset yellow;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}
#equip-item-btn {
  border: 5px solid var(--primary800);
  cursor: pointer;
}
  button {
    border-radius: 0.25rem;
    background-color: var(--primary400);
    border: 2px solid;
    border-color: #1dc5ba;
    padding: 10px 20px;
    font-size: 1.5rem;
    color: var(--primary800);
    border: 3px solid var(--primary800);
    font-weight: bold;
    transition-duration: 0.4s;
  }
  button:hover {
    background-color: var(--primary800);
    border: 3px solid var(--primary400);
    color: white;
  }
</style>