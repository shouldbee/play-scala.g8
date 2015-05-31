watch:
	./node_modules/.bin/webpack --watch

bootstrap:
	npm install
	./node_modules/.bin/tsd reinstall -so

build:
	./node_modules/.bin/webpack --config webpack-build.config.js -p
	rm -v public/javascripts/*.map

clean:
	rm -v public/javascripts/bundle.*

destroy:
	rm -rf node_modules typings
