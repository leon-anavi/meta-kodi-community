do_deploy_append_raspberrypi4() {
    echo "# Enable audio" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    echo "dtparam=audio=on" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
}
