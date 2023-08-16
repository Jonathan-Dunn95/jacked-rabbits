<template>
  <div class="container">
    <!-- <h2>{{ activeKid.username }} </h2> -->
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
      :class="{ selected: item === selectedItem }" 
      @click="selectItem(item)"
      />
    </div>
    <button id="purchase-item-btn" @click="purchaseItem(selectedItem)">Purchase Selected Item</button>
  </div>
</template>

<script>
import ItemStoreService from '../services/ItemStoreService'
import KidService from '../services/KidService';
import ClosetService from '../services/ClosetService';
import MascotService from '../services/MascotService';

export default {
  name: "store-block",
  data() {
    return {
      selectedCategory: 'Shirts',
      items: [],
      selectedItem: null,
      randomKid: null,
    }
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
      KidService.getKidById(this.$store.state.user.id)
      // .then(response => {
      //   this.$store.commit("SET_ACTIVE_KID", response);
      // })
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
    },
    selectItem(item) {
        this.selectedItem = item;
    },
    purchaseItem(item) {
      MascotService.getMascotByKidId(this.$store.state.user.id).then( response => {
        let closetEntry = {};
        console.log(item.id)
        closetEntry.mascotId = response.data.mascotId
        closetEntry.itemId = item.itemId;
        ClosetService.updateCloset(closetEntry)
      })
      this.$store.commit("PURCHASE_ITEM", item)
      let newKid = this.$store.state.user
      newKid.carrots = newKid.carrots-1;
      KidService.updateKid(newKid)
      console.log('Carrots should be down by 1')
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
  margin-bottom: 1rem;
}
.nav-tabs button {
  flex: 1;
  border-radius: 0.5rem;
  border: 5px solid var(--primary800);
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
#purchase-item-btn {
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