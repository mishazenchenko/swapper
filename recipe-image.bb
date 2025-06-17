SUMMARY = "My custom image recipe"
DESCRIPTION = "Some shit"

IMAGE_INSTALL += "mtd-utils"
IMAGE_FEATURES += "splash"

LICENSE = "MIT"

inherit core-image
inherit extrausers

ROOT_PASSWORD = "secret"
DEV_PASSWORD = "hackme"

EXTRA_USERS_PARAMS = "\
    groupadd developers;\
    useradd -p `openssl passwd ${DEV_PASSWORD}` developer;\
    useradd -g developers developer;\
    useradd -p `openssl passwd ${ROOT_PASSWORD}` root;"
