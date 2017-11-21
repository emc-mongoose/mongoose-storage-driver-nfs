[![master](https://img.shields.io/travis/emc-mongoose/mongoose-storage-driver-nfs/master.svg)](https://travis-ci.org/emc-mongoose/mongoose-storage-driver-nfs)
[![downloads](https://img.shields.io/github/downloads/emc-mongoose/mongoose-storage-driver-nfs/total.svg)](https://github.com/emc-mongoose/mongoose-storage-driver-nfs/releases)
[![release](https://img.shields.io/github/release/emc-mongoose/mongoose-storage-driver-nfs.svg)]()
[![Docker Pulls](https://img.shields.io/docker/pulls/emcmongoose/mongoose-storage-driver-nfs.svg)](https://hub.docker.com/r/emcmongoose/mongoose-storage-driver-nfs/)

[Mongoose](https://github.com/emc-mongoose/mongoose-base)'s NFS storage
driver

# Introduction

The storage driver extends the Mongoose's [Abstract NIO Storage Driver](https://github.com/emc-mongoose/mongoose-base/wiki/v3.6-Extensions#22-nio-storage-driver).
Also it uses [EMC ECS NFS-client library](https://github.com/EMCECS/nfs-client-java).

# Features

* API version: NFS v3
* Authentification: N/A?
* Item types: TODO
* Path listing input
* Automatic destination path creation on demand
* Data item operation types:
    * `create`, additional modes:
        * copy
    * `read`
        * full
        * random byte ranges
        * fixed byte ranges
        * content verification
    * `update`
        * full (overwrite)
        * random byte ranges
        * fixed byte ranges (with append mode)
    * `delete`
    * `noop`

# Usage

Latest stable pre-built jar file is available at:
https://github.com/emc-mongoose/mongoose-storage-driver-nfs/releases/download/latest/mongoose-storage-driver-nfs.jar
This jar file may be downloaded manually and placed into the `ext`
directory of Mongoose to be automatically loaded into the runtime.

```bash
java -jar mongoose-<VERSION>/mongoose.jar \
    --storage-driver-type=nfs \
    ...
```

## Docker

### Standalone

```bash
docker run \
    --network host \
    --entrypoint mongoose \
    emcmongoose/mongoose-storage-driver-nfs \
    -jar /opt/mongoose/mongoose.jar \
    --storage-type=nfs \
    ...
```

### Distributed

#### Drivers

```bash
docker run \
    --network host \
    --expose 1099 \
    emcmongoose/mongoose-storage-driver-service-nfs
```

#### Controller

```bash
docker run \
    --network host \
    --entrypoint mongoose \
    emcmongoose/mongoose-base \
    -jar /opt/mongoose/mongoose.jar \
    --storage-driver-remote \
    --storage-driver-addrs=<ADDR1,ADDR2,...> \
    --storage-driver-type=nfs \
    ...
```

## Advanced

### Sources

```bash
git clone https://github.com/emc-mongoose/mongoose-storage-driver-nfs.git
cd mongoose-storage-driver-nfs
```

### Test

```
./gradlew clean test
```

### Build

```bash

./gradlew clean jar
```

### Embedding

```groovy
compile group: 'com.github.emc-mongoose', name: 'mongoose-storage-driver-nfs', version: '<VERSION>'
```
