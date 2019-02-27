# rsocket-rpc-example

To build this project, issue the following command:

`./gradlew build`

Then, in one terminal, start the example RSocket RPC service by issuing the
following command:

`./gradlew :service:run`

That command will eventually output the following:

`<===========--> 90% EXECUTING`

That output indicates that the service is ready to accept connections from
clients. In another terminal, while the service is still running, issue the
following command:

`./gradlew :client:run`

That starts a client that connects to the service. You will see some output
from its interactions. You can review the code to see what this service
accomplishes:

**Interface Definition:**

* `service-idl/build/resources/main/service.proto`

**Client:**

* `client/src/main/java/io/netifi/rsocket/example/client/Main.java`

**Service:**

* `service/src/main/java/io/netifi/rsocket/example/service/DefaultSimpleService.java`
* `service/src/main/java/io/netifi/rsocket/example/service/Main.java`

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/netifi/rsocket-rpc-example/issues).

## License
Copyright 2019 [Netifi Inc.](https://www.netifi.com)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
