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
