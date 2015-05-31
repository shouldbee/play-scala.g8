var webpack = require('webpack');
var config = require("./webpack.config.js");
config.plugins = [
    new webpack.optimize.UglifyJsPlugin({
        compress: {
            warnings: false,
            drop_console: true
        }
    })
];

module.exports = config;
