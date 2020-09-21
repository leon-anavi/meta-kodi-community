FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://kodi-rpi.service"

WINDOWSYSTEM = "raspberrypi"
ARM_INSTRUCTION_SET = "arm"
do_package_qa[noexec] = "1"
do_file_ownership[fakeroot] = "1"
LDFLAGS += "-lpthread"

do_install_append_rpi() {
	install -m 0644 ${WORKDIR}/kodi-rpi.service ${D}/lib/systemd/system/kodi.service
}
