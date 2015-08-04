"""Echo anything written to stdin on stdout.

"""

__module_id__ = "$Id$"
#end_pymotw_header

import sys

sys.stdout.write('repeater.py: starting\n')
sys.stdout.flush()

while True:
    next_line = sys.stdin.readline()
    if not next_line:
        break
    sys.stdout.write(next_line)
    sys.stdout.flush()

sys.stdout.write('repeater.py: exiting\n')
sys.stdout.flush()
