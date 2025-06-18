SUMMARY = "My custom image recipe"
DESCRIPTION = "Some shit"

#IMAGE_INSTALL += "mtd-utils"
IMAGE_FEATURES += "splash"

LICENSE = "MIT"

inherit core-image
inherit extrausers

ROOT_PASSWORD = "secret"
DEV_PASSWORD = "hackme"

modify_shells(){
    printf "# /etc/shells: valid login shells:\n/bin/sh\n/bin/bash\n" \
        > ${IMAGE_ROOTFS}/etc/shells
}

modify_sudoers(){
    sed 's/# %sudo/%sudo/' < ${IMAGE_ROOTFS}/etc/sudoers > /
        ${IMAGE_ROOTFS}/etc/sudoers.tmp
    mv ${IMAGE_ROOTFS}/etc/sudoers.tmp ${IMAGE_ROOTFS}/etc/sudoers
}

EXTRA_USERS_PARAMS = "\
    groupadd developers;\
    useradd -g developers developer;"

#ROOTFS_POSTPROCESS_COMMAND += "modify_shells;"
