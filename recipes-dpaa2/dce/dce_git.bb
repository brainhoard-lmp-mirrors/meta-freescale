DESCRIPTION = "Decompression Compression Engine Userspace Utils"
SECTION = "dpaa2"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=956df5ea6cfe0a1dcf2dee7ca37c0cdf"

SRC_URI = "git://github.com/nxp-qoriq/dce;nobranch=1 \
      git://github.com/nxp-qoriq/qbman_userspace;nobranch=1;name=qbman;destsuffix=git/lib/qbman_userspace \
"
SRCREV = "0455555e5ce6f469d0c60e25f14a2340054a531a"
SRCREV_qbman = "a1af1e1528fe2e1ce0df1e6d9170b6c239c8ab4f"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'

do_install () {
    oe_runmake install DESTDIR=${D}
}

INSANE_SKIP_${PN} = "ldflags"
COMPATIBLE_MACHINE = "(qoriq-arm64)"
