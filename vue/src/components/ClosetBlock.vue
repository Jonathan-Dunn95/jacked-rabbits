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
      :class="{ selected: item === selectedItem }"
      @click="selectItem(item)"
      />
    </div>
    <button id="equip-item-btn" @click="equipItem(selectedItem)">Equip Selected Item</button>
  </div>
</template>

<script>
import ClosetService from '../services/ClosetService';
import MascotService from '../services/MascotService';

export default {
  name: "closet-block",
  data() {
    return {
      selectedItem: null,
      selectedCategory: 'Shirts',
    };
  },
  computed: {
    allClosetItems() {
      return this.$store.state.closetItems;
    },
    filteredItems() {
      const filteredItems = this.getFilteredItemsByCategory(this.selectedCategory);
      return filteredItems;
    },
  },
  methods: {
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
    changeCategory(category) {
      this.$store.commit('SET_SELECTED_CATEGORY', category)
    },
    selectItem(item) {
      console.log("Selected item:", item);
      this.selectedItem = item;
    },
    equipItem(item) {
      MascotService.getMascotByKidId(this.$store.state.user.id).then( response => {
        let updatedMascot = response.data
        if(item.itemId<13) {
          updatedMascot.shirt = item.itemId
        } else if(item.itemId<25) {
          updatedMascot.shoes = item.itemId
        } else if(item.itemId<37) {
          updatedMascot.hat = item.itemId
        } else if(item.itemId<49) {
          updatedMascot.accessory = item.itemId
        } else {
          updatedMascot.background = item.itemId
        }
        MascotService.updateMascotById(updatedMascot).then( () => {
          this.$store.commit("EQUIP_ITEM", item);
          // this.$router.go() // remove this once closet items pull from DB
        })
      })
      
    },
    getFilteredItemsByCategory(category) {
      const start = (category === 'Shirts' ? 1 : category === 'Shoes' ? 13 : category === 'Hats' ? 25 : category === 'Accessories' ? 37 : 49);
      const end = start + 11;
      return this.allClosetItems.filter(item => item.itemId >= start && item.itemId <= end);
    },
  },
  created() {
    MascotService.getMascotByKidId(this.$store.state.user.id).then( response => {
      ClosetService.getItemsByMascotId(response.data.mascotId).then( items => {
        this.$store.commit('SET_CLOSET_ITEMS', items.data)
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