package com.mahmoudroid.cryptocoins.views.coindetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mahmoudroid.domain.model.TeamMembers

@Composable
fun TeamListItem(
    teamMember: TeamMembers,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMember.position,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TeamListItemPreview() {

    val fakeMember = TeamMembers(
        name = "Mahmoud Ali",
        position = "Android Developer",
        id = "132"
    )

    MaterialTheme {
        TeamListItem(
            teamMember = fakeMember,
            modifier = Modifier.padding(16.dp)
        )
    }
}