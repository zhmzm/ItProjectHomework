import { createStore } from 'vuex'


// Create a new store instance.
export default createStore({
  state () {
    return {
      user: '',
      imageAddress: 'https://xuenihongzhao.info/'
    }
  },
  mutations: {
    setUser (state, data) {
      state.user = data;
    },
  }
})

