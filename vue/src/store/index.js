import { createStore } from 'vuex'


// Create a new store instance.
export default createStore({
  state () {
    return {
      user: '',
      login: 0,
      imageAddress: 'https://xuenihongzhao.info/'
    }
  },
  mutations: {
    setUser (state, data) {
      state.user = data;
    },
    setLogin (state, data) {
      state.login = data;
    },
  }
})

