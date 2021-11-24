// vue.config.js

module.exports = {
    
    publicPath: '/',
    devServer: {
        proxy: {
            '/api': {
                target: 'http://106.52.23.196:8081/', //对应服务器地址

                changeOrigin: true, //允许跨域

                ws: true,

                pathRewrite: {
                    '^/api': ''

                }

            }

        }

    }

}