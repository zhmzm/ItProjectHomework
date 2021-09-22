// vue.config.js

module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'http://192.168.137.43:8081/', //对应服务器地址

                changeOrigin: true, //允许跨域

                ws: true,

                pathRewrite: {
                    '^/api': ''

                }

            }

        }

    }

}
