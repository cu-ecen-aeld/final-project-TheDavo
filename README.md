# Repo Overview

This is the repository containing the build for CU Boulder's Embedded
Linux Development final project.

This project takes the display framebuffer of an SSD1306 driven OLED
display and transmits that information over a socket to a client such
that the content of the display can be shown.

# Image Setup

Due to short time, the image was built using `build/conf/local.conf`. In future
updates a custom image can be added to avoid using `local.conf` style image
setups.

To share the setup, a copy of it is tracked in the top directory with the
filename `build_local.conf`.

The image based to build this is `core-image-base` which works as a good base
for a Raspberry Pi target. After the shell is initialzed by sourcing the
`oe-init-build-env` file within the `poky` directory, build the image.

```sh
bitbake core-image-base
```

The images can then be found in `build/tmp/deploy/images/raspberrypi4`.

RPi Imager was used to flash the contents of the `.rpi-sdimg` file to an SD
card to create the bootable setup.

# Setting Up WiFi

This project uses WiFi to send data through local IP from the Raspberry Pi to
the client PC that is running the `bonnetmirror_client` application.

To set up WiFi, setting up the `wpa_supplicant.conf` file and starting the
WiFi adapter are required.

Boot into the Raspberry Pi 4, (not a headless method at this moment, more image
updates are required for that), add the network information to the
`wpa_supplicant.conf` file, and enable the WiFi adapter using `ifup wlan0`.

Many tutorials state that the `wpa_supplicant.conf` file is in the
`/etc/wpa_supplicant/wpa_supplicant.conf` location, but in this image it was
found in `/etc/wpa_supplicant.conf`. Open up the file in `vi` (or `nano`
if that is installed), and add the network information:

```sh
country=US
network = {
  ssid="MYSSID"
  psk="passphrase"
  key_mgmt=WPA-PSK
}
```

After turning on the WiFi, and running `bonnetmirror` the first screen
should show the local IP address of the Pi as well.

## Other Tools
There are other tools available such as `NetworkManger`, `connman`, and `iwd`,
but for the ease of use of a one-time setup as this, modifying the local
`wpa_supplicant.conf` file is enough.

# Enabling Root SSH

Unless `sudo` is installed with the Yocto image, SSHing with root is not
allowed.

Can be enabled by adding a line to the `sshd_config` file.

```bash
vi /etc/ssh/sshd_config
```

Add the line:

```bash
PermitRootLogin yes
```

Reboot, and now root-based ssh is allowed. Outside of this course this method
should only be allowed for debug purposes and is not generally a good practice
to allow people to login in as root.

# Running the App

Once ssh'd (or simply booted with a monitor + keyboard setup) the app can be
run by calling `bonnetmirror` if root, or `sudo bonnetmirror` if `sudo` is
installed and the user logged in does not have privileges.

# Wiki Linki

Project Wiki: https://github.com/cu-ecen-aeld/final-project-TheDavo/wiki

