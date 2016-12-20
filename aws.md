## Tips

### Security Groups.
+ Security Groups are stateful - i.e if an inbound rule is created, there is no need to create an outbound rule.
+ All inbound rules - denied, All outbound rules - Allowed. (Default)

### Volumes Vs snapshots.
+ Volume exists on EBS. Its a Virtual HDD
+ Snapshot is stored in S3. Snapshopts are incremental. Snapshots are point in time copies of volumes. Are encrypted volumes and are encrypted automatically. 
+ Volumes restored from snapshots are automatically encrypted.
+ Snapshots can be shared only if they are un-encrypted.
+ To create a snapshot for root device volume - The instance should be stopped. If not stopped, AWS will forcefully stop the volume.
+ Volumes are not encrypted by default.

### Ec2 Raid Volumes
+ Redundant array of independent disks. A bunch of disks acting as on disk to Operating Systems.
+ To increase the Disk I/O - Add additional volumes and create a RAID. This new volume will be spread across multiple EBS volumes. This increases the disk I/O.
+ Snapshot on RAID Array.( 3 Methods) - To avoid loosing of caches.
  + Freeze the file system
  + Unmount the Raid array
  + Shutdown the associated EC2 instance. (easy way)
+ RAID
  + Raid 0 : Stripped, No redundancy. Good performance(1 disk)
  + Raid 10 : Stripped, Mirrorred, Good redundancy, Good performance.
  + Stripped : Stripe across disks.(2 or more disks and stripe across disks.)
  + Mirrorred : 1 disk, mirror an exact copy to other disk. i.e we have redundancy.
  + Amazon discourages to use RAID5.(Use of parity - a checksum.)
+ 
