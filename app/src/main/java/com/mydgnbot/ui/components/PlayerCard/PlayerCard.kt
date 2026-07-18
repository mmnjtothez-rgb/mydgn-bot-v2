
@Composable
fun PlayerCard(
    player: Player,
    countdownState: CountdownState,
    onBought: () -> Unit,
    onCancel: () -> Unit,
    onOpenFutbin: () -> Unit
) {

    Card {

        Column {

            PlayerHeader(
                player = player,
                onOpenFutbin = onOpenFutbin
            )

            CountdownBar(
                state = countdownState
            )

            PriceSection(
                player = player
            )

            PlayerDetails(
                player = player
            )

            AccountSection(
                player = player
            )

            ActionButtons(
                expired = countdownState.isExpired,
                onBought = onBought,
                onCancel = onCancel
            )
        }
    }
}
