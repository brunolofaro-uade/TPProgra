package org.ejercicio3;

import org.ejercicio3.interfaces.IQueueOfQueues;

public class QueueOfQueues implements IQueueOfQueues {
    private QueueNode first;

    public void add(Queue a) {
        QueueNode queueNode = new QueueNode(a, null);

        if (this.first == null) {
            this.first = queueNode;
            return;
        }

        QueueNode candidate = this.first;

        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
        }

        candidate.setNext(queueNode);
    }

    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    public boolean isEmpty() {
        return this.first == null;
    }


    public Queue getFirst() {
        if (this.first == null) {
            System.out.println("No se puede obtener el primero de una cola vacia");
            return null;
        }
        return this.first.getValue();
    }

    public QueueOfQueues concatenate(QueueOfQueues[] queues) {
        QueueOfQueues concatenatedQueue = new QueueOfQueues();
        QueueOfQueues backupQueue = new QueueOfQueues();

        // Copiamos las colas de la QueueOfQueues inicial
        while (!this.isEmpty()) {
            Queue queueToCopy = this.getFirst();
            concatenatedQueue.add(queueToCopy);
            backupQueue.add(queueToCopy);
            this.remove();
        }

        // Volvemos a dejar la QueueOfQueues inicial como estaba
        while (!backupQueue.isEmpty()) {
            Queue queueToRestore = this.getFirst();
            this.add(queueToRestore);
            backupQueue.remove();
        }

        // Concatena las queues de las instancias de QueueOfQueues que se pasaron
        for (QueueOfQueues queue : queues) {
            while (!queue.isEmpty()) {
                Queue queueToConcat = queue.getFirst();
                concatenatedQueue.add(queueToConcat);
                queue.remove();
            }
        }

        return concatenatedQueue;
    }

    public Queue flat() {
        Queue flattenedQueue = new Queue();
        QueueOfQueues backupQueueOfQueues = new QueueOfQueues();

        // Crea una instancia aplanada del QueueOfQueues
        while (!this.isEmpty()) {
            Queue queueToAdd = this.getFirst();
            Queue backupQueue = new Queue();

            while (!queueToAdd.isEmpty()) {
                int valueToAdd = queueToAdd.getFirst();

                flattenedQueue.add(valueToAdd);
                backupQueue.add(valueToAdd);

                queueToAdd.remove();
            }

            backupQueueOfQueues.add(backupQueue);
            this.remove();
        }

        // Vuelve el QueueofQueues a su estado inicial
        while (!backupQueueOfQueues.isEmpty()) {
            Queue queueToRecover = backupQueueOfQueues.getFirst();
            this.add(queueToRecover);
            backupQueueOfQueues.remove();
        }

        return flattenedQueue;
    }

    public void reverseWithDepth() {
        StackOfQueues stackToReverseQueueOfQueues = new StackOfQueues();

        while (!this.isEmpty()) {
            Queue queueToReverse = this.getFirst();
            Stack stackToReverseQueue = new Stack();

            // Estos dos whiles revierten la queue
            while (!queueToReverse.isEmpty()) {
                int valueToReverse = queueToReverse.getFirst();
                stackToReverseQueue.add(valueToReverse);
                queueToReverse.remove();
            }

            Queue reversedQueue = new Queue();
            while (!stackToReverseQueue.isEmpty()) {
                int valueToReverse = stackToReverseQueue.getTop();
                reversedQueue.add(valueToReverse);
                stackToReverseQueue.remove();
            }

            // Acá necesito el stack de queues
            stackToReverseQueueOfQueues.add(reversedQueue);
            this.remove();
        }

        while (!stackToReverseQueueOfQueues.isEmpty()) {
            Queue queueToRecover = stackToReverseQueueOfQueues.getTop();
            this.add(queueToRecover);
            stackToReverseQueueOfQueues.remove();
        }
    }
}
