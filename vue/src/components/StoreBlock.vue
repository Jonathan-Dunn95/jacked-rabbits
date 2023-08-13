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
      <img v-for="item in filteredItems" 
      :key="item.itemId"
      :src="item.imgURL"
      @click="toggleItemSelected(item)"
      :class="{ selected: selectedItems.includes(item) }" />
    </div>
  </div>
</template>

<script>
import ItemStoreService from '../services/ItemStoreService'

export default {
  name: "store-block",
  data() {
    return {
      selectedCategory: 'Shirts',
      items: [],
      selectedItems: [],
    };
  },
  created() { 
    ItemStoreService.getAllItems()
    .then(response => {
        // success!
        this.items = response.data;
      })
      .catch(error => {
        console.error('An error occurred trying to load items!', error);
      });
  },
  computed: {
    filteredItems() {
      return this.items.filter(item => this.getCategoryFromItemId(item.itemId) === this.selectedCategory);
    },
  },
  methods: {
    // items in the items_store don't have categories so this is how they're set to be displayed
    getCategoryFromItemId(itemId) {
      if (itemId >= 1 && itemId <= 12) { 
        return 'Shirts';
      } else if (itemId >= 13 && itemId <= 24) {
        return 'Shoes';
      } else if (itemId >= 25 && itemId <= 36) {
        return 'Hats';
      } else if (itemId >= 37 && itemId <= 48) { 
        return 'Accessories';
      } else { 
        return 'Backgrounds';
      }
    },
    selectCategory(category) { 
      this.selectedCategory = category;
      this.selectedItems = [];
    },
    toggleItemSelected(item) {
      if (this.selectedItems.includes(item)) {
        this.selectedItems = [];
      } else {
        this.selectedItems = [item];
      }
    }
  }
}
</script>

<style scoped>
.container { 
  display: flex;
  border: 10px solid var(--primary800);
  background-color: var(--primary400);
  border-radius: 0.5rem;
}
.nav-tabs {
  display: flex;
  margin-bottom: 1rem;
  border-bottom: 10px solid var(--primary800);
  background-color: var(--primary800);
}
.nav-tabs button {
  flex: 1;
  border-radius: 0.5rem;
  height: 5rem;
  cursor: pointer;
}
.item-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  background-color: var(--primary400);
}
.item-grid img {
  max-width: 275px;
  max-height: 275px;
  width: 100%;
  border: 4px solid var(--primary800);
  border-radius: 0.5rem;
  cursor: pointer;
  margin-bottom: 1rem;
}
.nav-tabs button.active {
  background-color: var(--primary800);
  border: 3px solid var(--primary400);
  color: white;
}
.item-grid img.selected {
  border: 5px inset var(--primary600);
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}
</style>