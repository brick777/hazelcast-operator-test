# Getting Started

### Operator installation

#### 1. Add the Hazelcast Helm Charts repository to your Helm repository list by running the following command: <br/>

<code>helm repo add hazelcast https://hazelcast-charts.s3.amazonaws.com/ <br/></code>
<code>helm repo update</code>

#### 2. You can either deploy the Hazelcast Platform Operator<br/>

<code>helm install operator hazelcast/hazelcast-platform-operator --version=5.13.0 \
--set=installCRDs=true</code>

### Start the Hazelcast Cluster

#### 1. Create a Kubernetes secret to hold your license key.

<code>kubectl create secret generic hazelcast-license-key --from-literal=license-key=YOUR LICENSE KEY</code>

You have to generate the licence key if you don't have one yet.

#### 2. Apply the custom resource to start the Hazelcast cluster.<br/>

<code>kubectl apply -f kubernetes/hazelcast-enterprise.yaml</code>

### Check that the Hazelcast Cluster is Running

<code> kubectl get hazelcast</code>

### Clean up<br/>

<code>kubectl delete -f hazelcast.yaml</code><br/>
<code>kubectl delete -f hazelcast-enterprise.yaml</code></br>
<code>kubectl delete secret hazelcast-license-key</code><br/>
<code>helm uninstall operator</code>

References: <br/>
[Deploy a Cluster with the Hazelcast Platform Operator for Kubernetes](https://docs.hazelcast.com/operator/5.13/get-started)<br/>
[Configure TLS with Hazelcast Platform Operator tutorial](https://docs.hazelcast.com/tutorials/hazelcast-platform-operator-tls)

# Build docker image and deploy <br/>

- <code>docker build -t [your_container_tag] . </code>
- <code>docker push [your_container_tag]</code>
- <code>kubectl run hazelcast-client1 --image=[your_container_tag]</code>
- <code>kubectl run hazelcast-client2 --image=[your_container_tag]</code>

# Verifying distributed cache with application

To verify proper work of the distributed cache please use httpclient requests localized in <code>
/src/main/resources/httpclient</code>