DESCRIPTION = "Bonnetmirror - Mirror SSD1306 with a socket"
HOMEPAGE = "https://github.com/TheDavo/bonnetmirror"
LICENSE = "MIT"

LIC_FILES_CHKSUM = " \
	file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
"

# Use gitsm since the repo uses submodules
SRC_URI = " \
	gitsm://github.com/TheDavo/bonnetmirror.git;protocol=https;branch=main \
"

SRCREV = "5b26d3c7b2bc0775737a293f5a2ed5674881865b"

S = "${WORKDIR}/git"
FILES:${PN} += "${bindir}/bonnetmirror"

inherit pkgconfig

DEPENDS += "libgpiod"
EXTRA_OEMAKE += "CFLAGS+=-I${STAGING_DIR_TARGET}/usr/include"
# EXTRA_OEMAKE += "LDFLAGS+=-L${STAGING_DIR_TARGET}/usr/lib"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

# following the tutorial from the hello world yocto repo from the class
# https://github.com/cu-ecen-aeld/yocto-hello-world/blob/ecen5013-hello-world/meta-ecen5013/recipes-ecen5013/ecen5013-hello-world/ecen5013-hello-world_git.bb

do_install () {
	# create dir
	install -d ${D}${bindir}
	install -m 0755 ${S}/bin/bonnetmirror ${D}${bindir}
}
