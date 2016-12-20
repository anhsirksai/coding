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
 
### Create an AMI
+ first take a snapshot of a running instance. Then click on "Create Image" on that snapshot to create the AMI.
+ A complete copy of an EC2 instance. By default , AMI image is private. "Modify Image Permissions" - Add permissions to share b/n multiple aws accounts, make image public.
+ While making the AMI public : follow the best practices for security.
  + https://aws.amazon.com/articles/9001172542712674
  + Disable services and protocols that authenticate users in clear text (e.g. Telnet and FTP).
  + Do not start unnecessary network services on launch. Only administrative services (SSH/RDP) and the services required for your application should be started.
  + Securely delete all AWS credentials from disk and configuration files.
  + Securely delete any third-party credentials from disk and configuration files.
  + Securely delete any additional certificates or key material from the system.
  + Ensure that software installed on your AMI does not have default internal accounts and passwords (e.g. database servers with a default admin username and password).
  + Ensure that the system does not violate the Amazon Web Services Acceptable Use Policy. Examples include open SMTP relays or proxy servers.
+ Exam Tips :
  + AMI is region specific when created. So EC2 can be created only in that region. However, AMI's can be copied into other regions to create ec2 instances.
  
### EBS Root Volumes Vs Instance store.(Where OS can run on)
+ Instance store : cannot stop the instance. only terminate. Also called Ephimeral storage.
+ EBS : Can stop and take a snapshot. Can be stopped. 
+ Instance store : not persistant. On termination - deletes the instance store device.
+ EBS : can be detached and attached.(even the root file system.) This can be saved even after the instance termination.
+ Both can be rebooted.

### Cleation of ELB
