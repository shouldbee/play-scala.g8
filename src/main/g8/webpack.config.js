module.exports = {
    context: __dirname + "/app/assets/javascripts",
    entry: {
      app: "./app"
    },
    output: {
        path: __dirname + "/public/javascripts",
        filename: "bundle.[name].js"
    },
    resolve: {
      extensions: ["", ".ts", ".js"]
    },
    devtool: "source-map",
    module: {
        preLoaders: [
            { test: /\.ts$/, loader: "tslint" }
        ],
        loaders: [
            { test: /\.css$/, loader: "css?minimize"},
            { test: /\.styl$/, loader: 'style-loader!css-loader?minimize!stylus-loader' },
            { test: /\.jade$/, loader: 'jade' },
            { test: /\.ts$/, loader: "awesome-typescript-loader?emitRequireType=false&library=es6" }
        ]
    }
};
