#!/bin/zsh

export HUB_URL="http://localhost:4444/wd/hub"
export TEST_URL="https://the-internet.herokuapp.com/"
export TEST_USERNAME="tomsmith"
export TEST_PASSWORD="SuperSecretPassword!"

docker compose -f compose.yaml up -d